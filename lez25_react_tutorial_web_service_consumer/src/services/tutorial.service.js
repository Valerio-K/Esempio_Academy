import http from "../http-commons.js";

class TutorialService {

    //http://localhost:9090/rest/api/tutorials {GET}
    findAllTutorials() {
        return http.get(``);
    }

    //http://localhost:9090/rest/api/tutorials/id/idTutorial {GET}
    findTutorialById(id) {
        return http.get(`/id/${id}`);
    }

    //http://localhost:9090/rest/api/tutorials {POST}
    saveTutorial(tutorial) {
        return http.post(``, tutorial);
    }

    //http://localhost:9090/rest/api/tutorials {PUT}
    updateTutorial(tutorial) {
        return http.put(``, tutorial);
    }

    //http://localhost:9090/rest/api/tutorials/id/idTutorial {DELETE}
    removeTutorial(id) {
        return http.delete(`/id/${id}`);
    }
}

export default new TutorialService();
