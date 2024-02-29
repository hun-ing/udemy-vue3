export default {
    increment() {
        console.log('increment...');
        this.counter++
    },
    increase(value) {
        console.log('increase...');
        this.counter += value;
    },
}