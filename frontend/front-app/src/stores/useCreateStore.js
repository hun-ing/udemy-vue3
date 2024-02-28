import { defineStore } from 'pinia'

export const useCreateStore = defineStore('createStore', {
  state: () => ({
    counter: 0
  }),
  actions: {
    increment() {
      setTimeout(() => {
        this.counter++
      }, 2000)
    },
    increase(val) {
      this.counter += val
    }
  },
  getters: {
    finalCounter(state) {
      return state.counter
    },
    normalizedCounter() {
      const finalCounter = this.finalCounter
      if (finalCounter < 0) {
        return 0
      }
      if (finalCounter > 100) {
        return 100
      }
      return finalCounter
    }
  }
})