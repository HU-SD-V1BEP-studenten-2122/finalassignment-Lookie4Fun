export default class SnakeService {

    async getSnake() {
        return fetch('http://localhost:8080/restservices/bepslang')
            .then(response => response.json())

    }
    async updateSnake(updatedSnake) {
        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        return fetch('http://localhost:8080/restservices/bepslang/update', {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedSnake)
        }).then(response => {return response.json()})
            .catch(error => console.log('ERROR',error));
    }
}

