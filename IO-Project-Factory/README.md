# Recipe Blog Website

This is a simple recipe blog website built with Java, Spring Framework, HTML, CSS, and Mockito.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [To do List](#To)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Technologies](#technologies)

## Introduction

The Recipe Blog Website is a platform that allows users to share and discover recipes. It provides a user-friendly interface for browsing recipes, creating new ones, and interacting with other food enthusiasts. The website is built using Java with Spring Framework, utilizing Spring Web for handling web requests, Spring Data JPA for persistence with H2 Database, Thymeleaf for server-side HTML rendering, Lombok for reducing boilerplate code, and Mockito for testing.

## Features

- User Registration: Users can create an account to access additional features, such as submitting their own recipes.
- Recipe Browsing: Users can browse a collection of recipes, view recipe details, search for recipes, and filter results based on various criteria, such as ingredients.
- Recipe Creation and Editing: Registered users can create new recipes, providing details such as ingredients, preparation steps, cooking time, and images. They can also edit or delete their own recipes.
- Comments: Users can leave comments to share their feedback and ask questions.


## To Do List

✅ Comments: Users can leave comments to share their feedback and ask questions.
- [ ] Recipe Rating: Users can rate recipes
- [ ] User Profiles: Each user has a profile page that displays their submitted recipes, favorite recipes, and other relevant information.

## Installation

1. Clone the repository
If you have git installed, this is a recommended approach as you can easily update the repository. Simply run the following command:
`git clone https://github.com/abiezychudek/IO-Project.git`
Alternatively, you can also download the zip file of the repository at the top of the main repository page.
2. Pre-requisites
Before you can run this project, you must have the following installed:
- Java (version 17 or later)
- Maven (for managing and building the project)
3. Building the project
Navigate to the directory where you cloned the repository and execute the following command:
`mvn clean install`
This will install the necessary dependencies and build the project.

## Usage

1. Run the application 
2. Access the website in your browser at `http://localhost:8080`
3. Register a new account or use the provided demo account to explore the website.
4. Browse recipes, create new recipes, rate and review existing recipes, and interact with other users.


## Testing

The Recipe Blog Website includes unit tests to ensure the functionality of its components. Mockito is used as the mocking framework. To run the tests execute the following command:
`mvn test`
The results of the tests will be displayed in the terminal.


## Technologies

We would like to acknowledge the following open-source projects and libraries that made this project possible:

- [Spring Framework](https://spring.io/)
- [H2 Database](https://www.h2database.com/)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Lombok](https://projectlombok.org/)
- [Mockito](https://site.mockito.org/)
