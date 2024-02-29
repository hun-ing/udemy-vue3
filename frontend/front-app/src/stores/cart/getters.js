export default {
    cartTotal(state) {
        return state.total.toFixed(2)
    },
    itemTotal(state) {
        return (price, qty) => (price * qty).toFixed(2)
    },
    getItems(state) {
        return state.items;
    },
    getTotalSum(state) {
        return state.total;
    },
    getQuantity(state) {
        return state.qty;
    }
}