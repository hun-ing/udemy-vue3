import {useFetch} from '@vueuse/core';
import router from "@/router.js";

let timer;

export default {
    async signup(userData) {
        return this.auth(userData, 'signup');
    },
    async login(userData) {
        return this.auth(userData, 'login');
    },
    logout() {
        this.token = null;
        this.userId = null;

        clearTimeout(timer);

        localStorage.removeItem('token');
        localStorage.removeItem('userId');
        localStorage.removeItem('tokenExpiration');

        console.log('router1 = ', this.$router);
        console.log('router2 = ', this.router);
        console.log('router3 = ', router);
        // router.replace('/coaches');
    },
    async auth(userData, mode) {
        let url = 'http://localhost:8080/user';

        if (mode === 'signup') {
            url = 'http://localhost:8080/api/signup';
        }

        const {data, error} = await useFetch(
            url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(userData),
            });

        if (error.value) {
            throw new Error('Failed to authenticate. Check your login data.');
        }

        const parseData = JSON.parse(data.value);

        this.token = parseData.id;
        this.userId = parseData.id;

        const expirationDate = Date.now() + 5000;

        localStorage.setItem('token', parseData.id)
        localStorage.setItem('userId', parseData.id)
        localStorage.setItem('tokenExpiration', expirationDate)

        timer = setTimeout(() => {
            this.autoLogout();
        }, 5000);
    },
    tryLogin() {
        const token = localStorage.getItem('token');
        const userId = localStorage.getItem('userId');
        const tokenExpiration = localStorage.getItem('tokenExpiration');

        const expiresIn = +tokenExpiration - Date.now();

        if (expiresIn < 0) {
            this.logout();
            return;
        }

        timer = setTimeout(() => {
            this.autoLogout();
        }, expiresIn);

        if (token && userId) {
            this.token = token;
            this.userId = userId;
        }
    },
    autoLogout() {
        this.logout();
        this.didAutoLogout = true;
    },
};