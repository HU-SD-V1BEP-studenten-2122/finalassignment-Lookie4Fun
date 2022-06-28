export default class LoginService {
    isLoggedIn() {
        // //TODO: hoe ga je bepalen of iemand ingelogd is (geweest)?
        // return false;
        return fetch('https://testslang11.herokuapp.com/restservices/bepslang/login/isloggedin')
            .then(response => response.json())

    }

    login(user, password) {
        //TODO: inloggen met POST
        // return Promise.resolve();
        return fetch('https://testslang11.herokuapp.com/restservices/bepslang/login/'+user+"/"+password,{
            method:'POST'
        }).then(response => response.json())
    }

    getUser() {
        // //TODO: deze GET method test je token op server-side problemen. Je kunt client-side op zich wel 'ingelogd' zijn
        // //maar het zou altijd zomaar kunnen dat je token verlopen is, of dat er server-side iets anders aan de hand is.
        // //Dus het is handig om te checken met een -echte fetch- of je login-token wel echt bruikbaar is.
        // return Promise.resolve(null);
        return fetch('https://testslang11.herokuapp.com/restservices/bepslang/getUser')
            .then(response => response.json())
    }


    logout() {
        //TODO: hoe ga je eigenlijk iemand 'uitloggen'?
        return fetch('http://localhost:8080/restservices/bepslang/logout')
            .then(response => response.json())
    }
}
