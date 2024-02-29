export default {
    getProductById(state) {
        return (prodId) =>  state.products.find(product => product.id === prodId);
    }
}