export default class SnakeService {

    async getSnake() {
        return fetch('/restservices/bepslang')
            .then(response => response.json() )

    }
    async updateSnake(updatedSnake) {
        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        return fetch('/restservices/bepslang/update', {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedSnake)
        }).then(response => {return response.json()})
            .then(data => console.log("update",data))
            .catch(error => console.log('ERROR',error));
    }
}

