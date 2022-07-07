export default class LoginService {
    isLoggedIn() {
        // //TODO: hoe ga je bepalen of iemand ingelogd is (geweest)?
        // return false;
        return fetch('/restservices/bepslang/login/isloggedin')
            .then(response => response.json())
    }

    login(user, password) {
        //TODO: inloggen met POST
        // return Promise.resolve();
        fetch("restservices/login/"+user+"/"+password, {method: "POST", body: jsonRequestBody})
            .then(function (response) {
                if(response.ok) return response.json()
                else throw "Wrong username/password";
            })
            .then(myjson => window.sessionStorage.setItem("myJWT", myjson.JWT))
            .catch(error => console.log(error));
    }


    getUser() {
        // //TODO: deze GET method test je token op server-side problemen. Je kunt client-side op zich wel 'ingelogd' zijn
        // //maar het zou altijd zomaar kunnen dat je token verlopen is, of dat er server-side iets anders aan de hand is.
        // //Dus het is handig om te checken met een -echte fetch- of je login-token wel echt bruikbaar is.
        // return Promise.resolve(null);
        return fetch('/restservices/bepslang/getUser')
            .then(response => response.json())
    }


    logout() {
        //TODO: hoe ga je eigenlijk iemand 'uitloggen'?
        return fetch('/restservices/bepslang/logout')
            .then(response => response.json())
    }
}
