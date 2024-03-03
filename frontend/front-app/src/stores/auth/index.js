import {defineStore} from "pinia";
import actions from "@/stores/auth/actions.js";
import getters from "@/stores/auth/getters.js";

export const useAuthStore = defineStore('auth', {
    state: () => {
        return {
            userId: null,
            token: null,
            tokenExpiration: null,
        }
    },
    actions,
    getters,
})