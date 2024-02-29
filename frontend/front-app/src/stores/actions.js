export default {
    login() {
        this.isLoggedIn = true;
    },
    logout() {
        this.isLoggedIn = false;
    },
    incrementIndex() {
        setTimeout(() => {
            this.index++
            this.incrementIndex();
        }, 1000)
    }
}