export default {
    login() {
        console.log('login...');
        this.isLoggedIn = true;
    },
    logout() {
        console.log('logout...');
        this.isLoggedIn = false;
    },
}