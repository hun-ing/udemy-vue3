import {defineStore} from "pinia";
import actions from "@/stores/actions.js";
import getters from "@/stores/getters.js";

export const useGlobalStore = defineStore('global', {
    state: () => {
        return {
            isLoggedIn: false,
            index: 0,
        }
    },
    actions,
    getters
})