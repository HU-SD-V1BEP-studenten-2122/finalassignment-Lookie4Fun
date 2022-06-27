export default class SnakeService {

    url = 'https://testslang6.herokuapp.com/restservices/bepslang/'
    async getSnake() {
        return fetch('https://testslang7.herokuapp.com/restservices/bepslang')
            .then(response => response.json() )

    }
    async updateSnake(updatedSnake) {
        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        return fetch('https://testslang7.herokuapp.com/restservices/bepslang'+update, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedSnake)
        }).then(response => {return response.json()})
            .catch(error => console.log('ERROR',error));
    }
}

