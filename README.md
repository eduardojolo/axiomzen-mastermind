#axiomzen-mastermind#
This is a microservice built for the Axiom Zen challenge during the VanHackathon. It is an implementation of the Mastermind game with 8 colors and 8 positions. This microservice acts as the codemaker and a predefine number of codebreakers can join the same game to compete and see who can break de code first.

---

#How to run the microservice#
In order to start a new instance of axiomzen-mastermind microservice the following steps are necessary:

+ *Get the code*:
  Download the project.

+ *Recompile if you want*:
  You can recompile the code if you want, just run the command below in the project folder:
  
    `mvn clean install`

  You will need the Java and Maven configured in your environment.
  I have uploaded the target folder to GitHub so compiling the project is not really necessary, just use the .jar available at `/target`.

+ *Run the microservice*:
  The next step is to run the microservice. There are two ways of doing so:
  
  1) Using only Java:
    Execute the following command in the project folder. You will need only Java to do so:
  
      java -jar target/axiomzen-mastermind-0.0.1-SNAPSHOT.jar

  2) Using Maven:
    The command below requires Maven configured:
  
      mvn spring-boot:run

Done! Now you should have a local instance of the axiomzen-mastermind microservice at `http://localhost:8080/`

---

#How to play#
   This version of the game has no UI so, in order to play, the players should send requests to the microservice. The following endpoints are available:
    
+ */newgame* (POST):
To start a new game one of the players should send a POST to /newgame. The following JSON is an example of a valid request:

          `{
            "playerName": "My Beautiful Name",
            "numberOfPlayers" : 2
          }`
The properties purpose are:
`playerName`: (Required) The microservice requires a player name to create the game. It is required and an exception will be thrown if none is provided.
`numberOfPlayers`: (Optional) If a user wants to start a multiplayer game he can inform here the number of players the application should wait for. The game will wait for ALL the players to connect before accepting guesses. If no value is given the application will assume 1 player.

  Response example:
  
      {
        "gameKey": "[B@78a1b997",
          "playerKey": "[B@116cfef3"
      }
Where the `gameKey` identifies the game and the `playerKey` the player that created the game. Both values are necessary in the others endpoints.

+ */joingame* (POST):
If a game was created with the `numberOfPlayers` greater than 1 the game will wait for all the players to call the `/joingame` and get their player keys.

  Request example:

      {
        "gameKey" : "[B@2b1217d8",
        "playerName" : "Just another name"
      }


+ */guess* (POST):
To actually play the players should use the /guess and submit their guesses. The available color codes are:

    `'R', 'B', 'G', 'P', 'Y', 'O', 'V', 'M'`

  Lets see an example:

          `{
            "gameKey" : "[B@7d5d41f5",
            "playerKey" : "[B@24af8ebf",
            "guessedCode" : ["R","G","P","Y","V","M","M","G"]
          }`
In this example the player `[B@24af8ebf` guessed that the code of the game `[B@7d5d41f5` was `["R","G","P","Y","V","M","M","G"]`.
The response was:

        `{
            "correctCode": false,
            "keyPegs": [
                "W",
                "W",
                "W",
                "W"
            ],
            "gameHasAWinner": false
          }`

  `correctCode`: Indicates if the guessed code was correct or not.

  `keyPegs`: For each correct color in the wrong position a white peg (W) is given. For each correct color in the correct position a black peg (B) is given.

  `gameHasAWinner`: This indicates if the game has been solved by any of the players. Important for multiplayer games. The player could use the `/gameguesses` to see who won and all the players guesses.

+ */gameguesses* (GET):
If a player wants to see the historic of a game he can access it in `/gameguesses`:

      localhost:8080/gameguesses?gameKey=[B@2b1217d8

  He should inform only the `gameKey` and the following response would be given:

    {
        "winner": "Name",
        "playerGuesses": [
            {
                "playerName": "Name",
                "guesses": [
                    ["G", "G", "G", "G", "G", "G", "G", "G"],
                    ["R", "G", "P", "Y", "V", "M", "M", "G"]
                ]
            }
        ]
    }
It lists all the player gusses done in a game.

---

#Current components and architecture#
The axiomzen-mastermind microservice was built with Spring Boot + Spring MVC. It relies in a Hazelcast embedded instance to store the games, guesses and players. A few methods are synchronized for issues with concurrent access.
  
The Hazelcast map instances are configured to evict the data based in the LRU approach and not consume all the available memory, so the garbage collector has some space to work with.

---

#Improvements desired#
The first sketch considered an database behind the Hazelcast maps so, even if the data was evicted, all the games would still be available. I was going to make use of the write behind featues of Hazelcast to save the data asynchronously. This feature was not implemented because of the time required.
  
Another good improvement would be to use an standalone cache cluster. By doing so, multiple instances of the microservice could run togheter over the same data and have a loadbalancer in front of them. I decided to do an embedded approach to simplify the required steps in order to run the service during the tests.