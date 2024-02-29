import {defineStore} from "pinia";
import actions from "@/stores/cart/actions.js";
import getters from "@/stores/cart/getters.js";

export const useCartStore = defineStore('cart', {
    state: () => {
        return {
            items: [],
            total: 0,
            qty: 0,
        }
    },
    actions,
    getters
})