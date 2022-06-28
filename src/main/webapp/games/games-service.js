export default class GamesService {
    async getGameIds() {
        return fetch('http://localhost:8080/restservices/bepslang/allegames')
            .then(response => response.json())
    }

    async getReplay(id) {
        return fetch('http://localhost:8080/restservices/bepslang/'+ id)
            .then(response => response.json() )
    }

    async removeReplay(gameId) {
        return fetch('http://localhost:8080/restservices/bepslang/delete/'+gameId, {
            method: 'DELETE',
            headers:{'Content-Type':'application/json'}
        }).then(response => response.json())
    }
}
