<a name="readme-top"></a>
# Login Page using Java

## Table of Contents
1. [Introduction](#intro)
2. [Feature](#feature)
3. [Improvements](#improvements)
4. [Languages & Technology & Packages & Frameworks](#languages)
5. [Resources & References](#resources)

***
<a name="intro"></a>
## Introduction

This feature allows users to login. It also allows specific users to register new users. The features supports two types of users, either a normal User or an Admin. A User will only have access to the Landing, Login and User page. The Admin will have access to the Landing, Login, and Admin page. On the Adnin page, the Admin will have the ability to register new users as well as view the list of users already registered on the platform.

***
<a name="feature"></a>
## Features

### Landing Page
<img width="1137" alt="Screenshot 2023-11-05 at 17 46 08" src="https://github.com/abigail-143/DXC-Login-Abigail/assets/106907059/4cfd1bbe-52ed-4c1a-9e0d-1aafbd370e24">

Only the login page will be prompted at the main landing page.

### Login Page
<img width="1137" alt="Screenshot 2023-11-05 at 17 46 14" src="https://github.com/abigail-143/DXC-Login-Abigail/assets/106907059/93f03f8a-b0ac-4217-925d-01271d4438c4">
<img alt="Screenshot 2023-11-06 at 13 52 14" src="https://github.com/abigail-143/DXC-Login-Abigail/assets/106907059/571d9728-a282-4b0f-9d75-119dd32d889e">
<img alt="Screenshot 2023-11-06 at 13 52 21" src="https://github.com/abigail-143/DXC-Login-Abigail/assets/106907059/eba769af-edc4-4f83-b13c-e6d0c3d6c4c8">

#### Frontend
Using their username and password, users will be able to login to the site. If an invalid username or password is submitted, the platform will prompt the user accordingly.

#### Backend
Depending on their login details, more information on their account will be sent across, such as their clearance level. If the user has a "User" clearance, they will be navigated to the normal User page. If the user has an "Admin" clearance, they will be navigated to the Admin page upon successful login.

### User Page
<img width="1137" alt="Screenshot 2023-11-05 at 17 46 26" src="https://github.com/abigail-143/DXC-Login-Abigail/assets/106907059/e74d55e3-39ee-4fd5-b650-f561ee0c3e98">

Users with only "User" access will be navigated to a simple user page that will only greet the user by their username. Users have the option to log out as well.

### Admin Page
<img width="1137" alt="Screenshot 2023-11-05 at 17 46 42" src="https://github.com/abigail-143/DXC-Login-Abigail/assets/106907059/9a68f850-ee7e-4d20-bfe1-ded7953185f2">
<img width="1137" alt="Screenshot 2023-11-05 at 17 47 56" src="https://github.com/abigail-143/DXC-Login-Abigail/assets/106907059/23de1b48-98c4-486a-ae13-869220b32e17">

Users with "Admin" access will be navigated to the admin page which allows the user to register new users as well as view a list of existing users.

***
<a name="improvements"></a>
## Improvements

1. Proper logout method.
2. Allowing anyone to register but only with "User" clearance. To allow Admins to toggle the clearance levels of registered users.

***
<a name="languages"></a>
## Languages & Technology & Packages & Frameworks

- HTML
- CSS
- TypeScript
- React (VITE)
- Java
- Spring
- PostgreSQL

***
<a name="resources"></a>
## Resources & References

- [https://www.youtube.com/watch?v=x_nfnVU0wAI](https://www.youtube.com/watch?v=x_nfnVU0wAI)
- [https://www.youtube.com/watch?v=FOvBYJxGPTQ&t=266s](https://www.youtube.com/watch?v=FOvBYJxGPTQ&t=266s)
- [https://education.launchcode.org/java-web-development/chapters/enums/enums-in-models.html](https://education.launchcode.org/java-web-development/chapters/enums/enums-in-models.html)
- [https://www.baeldung.com/java-bean-validation-not-null-empty-blank](https://www.baeldung.com/java-bean-validation-not-null-empty-blank)
- [https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html#getOne(ID)](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html#getOne(ID))
- [https://www.baeldung.com/a-guide-to-java-enums](https://www.baeldung.com/a-guide-to-java-enums)
- [https://www.youtube.com/watch?v=nsQb5Au6EHQ&ab_channel=B2Tech](https://www.youtube.com/watch?v=nsQb5Au6EHQ&ab_channel=B2Tech)


<p align="right">(<a href="#readme-top">back to top</a>)</p>
