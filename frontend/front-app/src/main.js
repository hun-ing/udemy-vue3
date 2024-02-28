import App from './App.vue';
import {createApp} from 'vue'
import {createPinia, defineStore} from 'pinia'

const app = createApp(App)

export const useCreateStore = defineStore('createStore', {
    state: () => ({
        counter: 0
    }),
})

app.use(createPinia())

app.mount('#app')
