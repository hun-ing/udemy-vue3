import { defineStore } from 'pinia'
import actions from "@/stores/userAuth/actions.js";
import getters from "@/stores/userAuth/getters.js";

export const useUserAuthStore = defineStore('userAuth', {
  state: () => ({
    isLoggedIn: false,
  }),
  actions,
  getters
})