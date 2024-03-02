import {defineStore} from "pinia";
import actions from "@/stores/coaches/actions.js";
import getters from "@/stores/coaches/getters.js";

export const useCoachesStore = defineStore('coaches', {
    state: () => {
        return {
            coaches: []
        }
    },
    actions,
    getters,
})