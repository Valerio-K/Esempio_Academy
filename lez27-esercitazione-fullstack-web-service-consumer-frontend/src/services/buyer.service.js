import http from "../http-commons.js";

class BuyerService {

    //http://localhost:9090/rest/api/buyer {GET}
    findAllBuyers() {
        return http.get(``);
    }

    //http://localhost:9090/rest/api/buyer/varNumber/varNumber {GET}
    findBuyerById(vatNumber) {
        return http.get(`/vatNumber/${vatNumber}`);
    }

    //http://localhost:9090/rest/api/buyer {POST}
    saveBuyer(buyer) {
        return http.post(``, buyer);
    }

    //http://localhost:9090/rest/api/buyer {PUT}
    updateBuyer(buyer) {
        return http.put(``, buyer);
    }

    //http://localhost:9090/rest/api/buyer/varNumber/varNumber {DELETE}
    removeBuyer(vatNumber) {
        return http.delete(`/vatNumber/${vatNumber}`);
    }
}

export default new BuyerService();
