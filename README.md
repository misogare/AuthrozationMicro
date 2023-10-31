
Authorization Microservice
This repository contains an Android application that incorporates an authentication and authorization microservice. The application is designed to provide a user-friendly interface for user login, password reset, and related functionalities. Below, you will find information on how to use this microservice and the associated Android application.


Getting Started
To get started with this authorization microservice, follow the steps outlined below:

Clone this repository to your local machine.

Open the Android Studio project associated with this repository.

Update the base URL in the Retrofit configurations:

Open BlankFragment.kt and MainActivity.kt.
Replace the base URL in the Retrofit configurations with the URL of your own authentication microservice.
Build and run the Android application.

Authentication and Login
Authentication API
The authentication API is used to validate user credentials.
It provides the following endpoint: /auth/login.
Users are required to enter a username and password to log in.
Upon successful login, users will receive a success message. In case of login failure, an appropriate error message will be displayed.
Usage
Launch the application.

On the login screen, enter your username and password.

Click the "Login" button to send a login request to the microservice.

Upon receiving a response from the microservice, the application will display the login status.

Successful login will redirect you to the main dashboard (MainActivity2).

Password Reset
Password Reset API
The password reset API is used to facilitate password recovery.
It provides the following endpoints: /auth/forgotpassword and /auth/resetpassword.
Users can initiate the password reset process by providing their username.
After initiating the reset, users will receive instructions to change their password.
Usage
If you forget your password, navigate to the password reset screen by clicking the "Forgot Password" button on the login screen.

Enter your username and click the "Reset Password" button.

If your username is found in the database, you will receive a notification to change your password.

You will be redirected to the password reset screen (MainActivity3) where you can enter and confirm your new password.

After successful password reset, you will receive a confirmation message.

Note
This repository serves as a demonstration of how to implement authentication and password reset functionality in an Android application.
The provided code should be adapted and integrated into your own Android application and authentication microservice.
Feel free to explore and utilize this authorization microservice as a foundation for your authentication needs within your Android applications.

If you have any questions or encounter issues, please refer to the code and documentation for further details.

Happy coding!
