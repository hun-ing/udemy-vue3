import App from './App.vue';
import {createApp} from 'vue'
import {createPinia} from 'pinia'
import BaseBadge from "@/components/ui/BaseBadge.vue";
import router from "@/router.js";

const app = createApp(App)

app.use(createPinia())
app.use(router);

app.component('BaseBadge', BaseBadge);

app.mount('#app')
