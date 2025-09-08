# Random Word

A **Spring Boot REST application** that provides a "Random Word" feature. This project fetches a random word daily and retrieves its definitions using external APIs. It also implements caching to reduce API calls and provides clean REST endpoints for easy consumption.

---

## **Table of Contents**

1. [Features](#features)
2. [Architecture](#architecture)
3. [Technologies Used](#technologies-used)
4. [Setup & Installation](#setup--installation)
5. [Running the Application](#running-the-application)
6. [API Documentation](#api-documentation)
7. [Example Output](#example-output)
9. [Exception Handling](#exception-handling)

---

## **Features**

* Fetch a random word daily using [Random Word API](https://random-word-api.herokuapp.com/).
* Retrieve definitions and part-of-speech for the word using [Dictionary API](https://dictionaryapi.dev/).
* Backend caching using **Caffeine** to store Word of the Day for 24 hours.
* REST endpoint: `/wordOfTheDay`.
* Swagger UI documentation for easy API exploration.
* Professional exception handling with meaningful error responses.

---

## **Architecture**

1. **Controller:** Handles HTTP requests (`WordController`).
2. **Service:** Fetches data from external APIs (`WordService`).
3. **Model Classes:** Represents API responses (`WordResponse`, `DictionaryResponse`, `Meaning`, `DefinitionWithPOS`).
4. **Caching:** Word of the Day is cached for 24 hours to reduce API calls.
5. **Exception Handling:** Custom exceptions (`WordFetchException`, `DictionaryFetchException`) and global handler (`GlobalExceptionHandler`).

---

## **Technologies Used**

* Java 17
* Spring Boot 3
* Spring restTemplate (for reactive API calls)
* Spring Cache + Caffeine
* Swagger
* Maven

---

## **Setup & Installation**

1. **Clone the repository:**

```bash
git clone https://github.com/Didar1313/random-word.git
cd random-word
```

2. **Install dependencies using Maven:**

```bash
mvn clean install
```

3. **Run the application:**

```bash
mvn spring-boot:run
```

---

## **Running the Application**

* The server runs on `http://localhost:8080` by default.
* **Endpoint:**

| HTTP Method | Endpoint        | Description                          |
| ----------- | --------------- | ------------------------------------ |
| GET         | `/wordOfTheDay` | Returns today’s word and definitions |

---

## **API Documentation**

* Swagger UI: `http://localhost:8080/swagger-ui.html`

## **Example Output**

**Request:**

```http
GET /wordOfTheDay
```

**Response:**

```json
{
  "word": "tarragon",
  "definitions": [
    {
      "definition": "A perennial herb, the wormwood species Artemisia dracunculus, from Europe and parts of Asia.",
      "partOfSpeech": "noun"
    },
    {
      "definition": "The leaves of this plant (either fresh, or preserved in vinegar / oil mixture) used as a seasoning.",
      "partOfSpeech": "noun"
    }
  ]
}
```
---

## **Exception Handling**

* **WordFetchException:** Triggered if the random word API fails. Returns `503 SERVICE UNAVAILABLE`.
* **DictionaryFetchException:** Triggered if dictionary API fails. Returns `503 SERVICE UNAVAILABLE`.
* **Generic Exception:** Any other uncaught exception returns `500 INTERNAL SERVER ERROR`.

**Sample Error Response:**

```json
{
  "timestamp": "2025-08-29T12:34:56",
  "error": "Word Fetch Error",
  "message": "Failed to fetch random word"
}
```
