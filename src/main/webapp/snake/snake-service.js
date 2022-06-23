export default class SnakeService {

    async getSnake() {

        fetch('https://battlesnake-lookie4fun.herokuapp.com/restservices/bepslang')
            .then((response) => {
                if (!response.ok) {
                    throw new Error(response.error)
                }
                return Promise.resolve(response.json());
            })
    }

    async updateSnake(updatedSnake) {
        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        fetch('https://battlesnake-lookie4fun.herokuapp.com/restservices/bepslang', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedSnake)
        }).then(response => {return response.json()})
            .catch(error => console.log('ERROR'));
    }
}

