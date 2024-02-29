export default {
    userIsAuthenticated(state) {
        console.log('userIsAuthenticated...');
        return state.isLoggedIn;
    }
}