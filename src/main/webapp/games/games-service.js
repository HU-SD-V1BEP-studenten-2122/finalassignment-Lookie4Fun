export default class GamesService {
    async getGameIds() {
        return fetch('https://testslang11.herokuapp.com/restservices/bepslang/allegames')
            .then(response => response.json())
    }

    async getReplay(id) {
        return fetch('https://testslang11.herokuapp.com/restservices/bepslang/'+ id)
            .then(response => response.json() )
    }

    async removeReplay(gameId) {
        return fetch('https://testslang11.herokuapp.com/restservices/bepslang/delete/'+gameId, {
            method: 'DELETE',
            headers:{'Content-Type':'application/json'}
        }).then(response => response.json())
            .catch(error => console.log('ERROR',error));
    }
}
