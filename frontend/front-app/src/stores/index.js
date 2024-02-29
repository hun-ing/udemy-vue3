import {defineStore} from "pinia";
import getters from "@/stores/getters.js";
import actions from "@/stores/actions.js";

export const useGlobalStore = defineStore('global', {
    state: () => {
        return {

        }
    },
    actions,
    getters
})