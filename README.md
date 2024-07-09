# NIS x Unicef | Case Management Application

![logo-unicef](https://github.com/NoMoreZer0/unicef/assets/92913254/169ce014-9c7c-401a-aede-e54f2763e4d6)

## Description
Presented case management application for managing childs with special needs. Project itself was developed for the psychological center of the NIS schools and their pupils under the funding of UNICEF.
Portal itself contains several functionalities, such as:
* Storing information about the students, managers and teachers.
* Granting role priveleges for certain users.
* Presenting large administrative forms in convenient way.
* Having an option to download reports in pdf/word document and presenting them in beautiful graphs/tables... and more

Overall, application covers all needs for managing certain business process regarding children with needs.

## Technolgy specification
It is decided to use [JMIX](https://www.jmix.io/) full-stack framework for business applications as main stack of the project.

Jmix is a set of libraries and tools to speed up Spring Boot data-centric application development. Jmix provides a lot of ready-to-use functionality out of the box. You can plug in advanced system functionality like complex data security and audit as well as business functionality like reporting or business process execution engine in a few lines of code.

## Using Jmix
To get started, download Jmix Studio - a plugin for IntelliJ IDEA. It helps you at all stages of the application development: creating and configuring a project, defining data model, generating database migration scripts, developing UI screens in a visual editor. It provides advanced navigation, code completion and inspections specific to Jmix projects.

To learn Jmix, complete the tutorial which walks you through the process of building a full-stack web application. It covers the entire development process, from data modelling to creating UI and managing access rights.

## Building From Source

- Checkout the repository:
  ```bash
  git clone https://github.com/NoMoreZer0/unicef
  ```
- Install JDK 17.
- Build and publish the framework modules to the local Maven:
    ```bash
    cd unicef
    ./gradlew publishToMavenLocal
    ```
- If you want to build Gradle plugins, Studio templates or framework translations, execute `./gradlew publishToMavenLocal` in the respective directories:
  - `jmix-gradle-plugin` - a Gradle plugin for building Jmix applications.
  - `jmix-build` - an internal Gradle plugin which encapsulates the framework build logic. It's not used when building applications.
  - `jmix-templates` - templates used by Studio new project wizard.
  - `jmix-translations` - framework [translations](https://docs.jmix.io/jmix/localization/framework-translations.html).
 
### License
Jmix is an open-source project distributed under the [Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0) license. The same licensing is applied to most of the framework’s add-ons.

The framework is also complemented with commercial tools with separate [licensing and pricing](https://www.jmix.io/subscription-plans-and-prices/) for individuals and companies.
