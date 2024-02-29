export default {
    finalCounter(state) {
        console.log('finalCounter...');
        return state.counter
    },
    normalizedCounter() {
        console.log('normalizedCounter...');
        const finalCounter = this.finalCounter
        if (finalCounter < 0) {
            return 0
        }
        if (finalCounter > 100) {
            return 100
        }
        return finalCounter
    },
}