export default class GamesService {
    async getGameIds() {
        return fetch('https://testslang10.herokuapp.com/restservices/bepslang/allegames')
            .then(response => response.json())
    }

    async getReplay(id) {
        return fetch(url+ id)
            .then(response => response.json() )
    }

    async removeReplay(gameId) {
        return fetch(url+gameId), {
            method: 'DELETE'}
    }
}
