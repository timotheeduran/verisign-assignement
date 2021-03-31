# Verisign Assignment
Simple tool to check if a given number is prime or not. It includes a ReactJS frontend and a Spring Boot Java backend.

## Structure

`/backend` contains all the code related to Spring Boot for the backend
`/frontend` contains all the code related to ReactJS for the frontend

## Running the project

### Backend

1. Go the the `/backend` folder.
2. On macOS, run `./mvnw spring-boot:run`.
3. The server is now running on `http://localhost:8080` and accepts POST requests here `http://localhost:8080/checker`.

### Frontend

1. Go the the `/frontend` folder.
2. On macOS, run `npm run start`.
3. The frontend is now accessible here `http://localhost:3000`.
4. Some browser including Google Chrome will prompt an error when submitting the form asking for the `Access-Control-Allow-Headers` header. A quick fix is to run `open /Applications/Google\ Chrome.app --args --user-data-dir="/var/tmp/Chrome dev session" --disable-web-security` on macOS.

## Possible improvements

* From validation is weak. We should check that the given numbers are not too large or too small in both front and backend.
* We should use a captcha or at least a honeypot to avoid basic attacks.
* We should use CSRF Tokens to avoid Cross-Site Reference Forgery.
* It would be great to check if the backend code follows the good practices recommended by the Spring Boot community.
* ReactJS code should be refactored, tested, and documented.
* The UI/UX is basic; the user experience could largely be improved.

## Credits
Timothée Duran