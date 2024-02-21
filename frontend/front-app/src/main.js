import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import BaseCard from "@/components/UI/BaseCard.vue";

const app = createApp(App)

app.use(createPinia())
app.component('BaseCard', BaseCard);

app.mount('#app')
