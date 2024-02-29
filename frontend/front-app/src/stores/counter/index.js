import { defineStore } from 'pinia'
import actions from "@/stores/counter/actions.js";
import getters from "@/stores/counter/getters.js";

export const useCounterStore = defineStore('counter', {
  state: () => ({
    counter: 0,
  }),
  actions,
  getters
})