
# Rick and Morty API Client

It is an application written in Java and Spring Boot that queries the Rick and Morty API.

What combines information from endpoints:

- [Get a single character](https://rickandmortyapi.com/documentation/#get-a-single-character)
- [Get a single location](https://rickandmortyapi.com/documentation/#get-a-single-location)



## Authors

- [@hmtm](https://www.github.com/HugoMartinThielemannMoreno)


## Run Locally

Clone the project

```bash
  git clone https://github.com/HugoMartinThielemannMoreno/rick-and-morty-api-client
```

Go to the project directory

```bash
  cd rick-and-morty-api-client
```
Start the application

```bash
  mvn spring-boot:run
```


## Usage/Examples

### Request
The id parameter is of type Integer.

```cURL
curl -X GET --location "http://localhost:8080/rick-and-morty-api-client/api/characters/{{id}}"
```
### Response
#### When you find a character
```json
{
  "id": 1,
  "name": "Rick Sanchez",
  "status": "Alive",
  "species": "Human",
  "type": "",
  "origin": {
    "name": "Earth (C-137)",
    "url": "https://rickandmortyapi.com/api/location/1",
    "dimension": "Dimension C-137",
    "residents": [
      "https://rickandmortyapi.com/api/character/38",
      "https://rickandmortyapi.com/api/character/45",
      "https://rickandmortyapi.com/api/character/71",
      "https://rickandmortyapi.com/api/character/82",
      "https://rickandmortyapi.com/api/character/83",
      "https://rickandmortyapi.com/api/character/92",
      "https://rickandmortyapi.com/api/character/112",
      "https://rickandmortyapi.com/api/character/114",
      "https://rickandmortyapi.com/api/character/116",
      "https://rickandmortyapi.com/api/character/117",
      "https://rickandmortyapi.com/api/character/120",
      "https://rickandmortyapi.com/api/character/127",
      "https://rickandmortyapi.com/api/character/155",
      "https://rickandmortyapi.com/api/character/169",
      "https://rickandmortyapi.com/api/character/175",
      "https://rickandmortyapi.com/api/character/179",
      "https://rickandmortyapi.com/api/character/186",
      "https://rickandmortyapi.com/api/character/201",
      "https://rickandmortyapi.com/api/character/216",
      "https://rickandmortyapi.com/api/character/239",
      "https://rickandmortyapi.com/api/character/271",
      "https://rickandmortyapi.com/api/character/302",
      "https://rickandmortyapi.com/api/character/303",
      "https://rickandmortyapi.com/api/character/338",
      "https://rickandmortyapi.com/api/character/343",
      "https://rickandmortyapi.com/api/character/356",
      "https://rickandmortyapi.com/api/character/394"
    ]
  },
  "episode_count": 51
}
```
#### When you can't find a character, he received a response like this.
```json
{
  "timestamp": "2023-02-28T02:20:34.982+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Character not found",
  "path": "/rick-and-morty-api-client/api/characters/1"
}
```
