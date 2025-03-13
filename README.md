# Project Documentation for Mega City Cab Reservation Service

## Introduction
This document provides an overview of the Mega City Cab Reservation Service project, detailing the version control techniques used and the daily updates applied to the project. The project is hosted on a public GitHub repository for easy access and collaboration.

## Repository Setup
### Creating the GitHub Repository
1. Log in to your GitHub account.
2. Click on the **New** button to create a new repository.
3. Name your repository `mega-city-cab-backend`.
4. Set the repository to **Public**.
5. Initialize the repository with a README file.
6. Click on **Create repository**.

### Initial Setup
1. Clone the repository to your local machine:
    ```sh
    git clone https://github.com/dinethjanitha/mega-city-cab-backend.git
    ```
2. Navigate to the project directory:
    ```sh
    cd mega-city-cab-backend
    ```

## Version Control Techniques
### Branching Strategy
- **Master Branch**: The main branch where the stable code resides.
- **Feature Branches**: Separate branches for each new feature or bug fix.
    - Naming convention: `feature/feature-name` or `bugfix/bug-description`
- **Release Branches**: Branches used for preparing a new production release.
    - Naming convention: `release/version-number`

### Commit Messages
- Follow a consistent format for commit messages:
    ```
    [TYPE] Short description of the change

    [TYPE] can be one of:
    - feat: A new feature
    - fix: A bug fix
    - docs: Documentation changes
    - style: Code style changes (formatting, etc.)
    - refactor: Code refactoring
    - test: Adding or updating tests
    - chore: Other changes that don't modify src or test files
    ```

### Tagging
- Use semantic versioning for tags:
    ```
    git tag -a v1.0.0 -m "Initial release"
    git push origin v1.0.0
    ```

## Daily Updates
### Day 1: Initial Setup
- Created the GitHub repository.
- Added the initial project files.
- Commit: [8ae040a309dd0cdb17c05ce8c6c7d126afc68fa4](https://github.com/dinethjanitha/mega-city-cab-backend/commit/8ae040a309dd0cdb17c05ce8c6c7d126afc68fa4)

### Day 2: Added User Management Features
- Created the `feature/user-management` branch.
- Implemented user registration and login.
- Merged the feature branch into the `master` branch.
- Commit: [b0df89d12edfdfc398d4f66757d98d3d706a55cd](https://github.com/dinethjanitha/mega-city-cab-backend/commit/b0df89d12edfdfc398d4f66757d98d3d706a55cd)
- Tag: `v1.1.0`

### Day 3: Integrated Payment Gateway
- Created the `feature/Cab-Management` branch.
- Implemented cab adding and managing.
- Merged the feature branch into the `master` branch.
- Commit: [44d820fe17806a0cbf0526d47a365b12183bc555](https://github.com/dinethjanitha/mega-city-cab-backend/commit/44d820fe17806a0cbf0526d47a365b12183bc555)
- Tag: `v1.2.0`

### Day 4: Enhanced Booking System
- Created the `feature/booking-system` branch.
- Enhanced the booking system to support multiple cabs and advanced scheduling.
- Merged the feature branch into the `master` branch.
- Commit: [a06b30c1ce8655ea1a4cf8d435a40baec010e676](https://github.com/dinethjanitha/mega-city-cab-backend/commit/a06b30c1ce8655ea1a4cf8d435a40baec010e676)
- Tag: `v1.3.0`

## CI/CD Deployment
This Jenkins pipeline script defines a Continuous Integration/Continuous Deployment (CI/CD) process for the `mega-city-cab-backend` project. The pipeline is composed of several stages that automate the workflow from code checkout to deployment. Below is a detailed description of each stage:

### Pipeline Overview
- **Agent**: The pipeline runs on any available Jenkins agent.
- **Tools**: Ensures that Maven version 3.9.9 is installed on Jenkins.

### Stages
1. **Checkout**
    - **Purpose**: Retrieves the latest code from the GitHub repository.
    - **Steps**:
        - Uses the `git` command to clone the repository `https://github.com/dinethjanitha/mega-city-cab-backend.git`.

2. **Build**
    - **Purpose**: Builds the project using Maven.
    - **Steps**:
        - Executes `mvn clean package` to clean the project and package it into a deployable artifact.

3. **Test**
    - **Purpose**: Runs the unit tests for the project.
    - **Steps**:
        - Executes `mvn test` to run the project's tests and ensure code quality.

4. **Deploy**
    - **Purpose**: Deploys the built application locally.
    - **Steps**:
        - Runs the command `java -jar target/mega-city-cab-backend-0.0.1-SNAPSHOT.jar &` to start the application using the generated JAR file.

### Post Actions
- **Success**
    - **Purpose**: Provides feedback on successful deployment.
    - **Steps**:
        - Prints a message `Deployment was successful!`.

- **Always**
    - **Purpose**: Ensures the workspace is cleaned up after the pipeline execution.
    - **Steps**:
        - Executes `cleanWs()` to delete the workspace files and directories.

## Report Link
The public GitHub repository for the Mega City Cab Reservation Service can be accessed at:
[GitHub Repository](https://github.com/dinethjanitha/mega-city-cab-backend)

## Conclusion
This documentation highlights the version control techniques and daily updates applied to the Mega City Cab Reservation Service project. By following a structured approach to version control, we ensured a smooth and efficient development process, enabling easy collaboration and continuous integration.