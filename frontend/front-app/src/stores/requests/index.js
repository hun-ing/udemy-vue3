import {defineStore} from "pinia";
import actions from "@/stores/requests/actions.js";
import getters from "@/stores/requests/getters.js";

export const useRequestsStore = defineStore('requests', {
    state: () => {
        return {
            requests: []
        }
    },
    actions,
    getters
})