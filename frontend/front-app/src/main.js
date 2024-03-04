import App from './App.vue'
import {createApp, defineAsyncComponent, markRaw} from 'vue'
import { createPinia } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
import router from '@/router.js'
import BaseCard from '@/components/ui/BaseCard.vue'
import BaseButton from '@/components/ui/BaseButton.vue'
import BaseBadge from '@/components/ui/BaseBadge.vue'
import BaseSpinner from '@/components/ui/BaseSpinner.vue';
// import BaseDialog from '@/components/ui/BaseDialog.vue';

const BaseDialog = defineAsyncComponent(() => import('@/components/ui/BaseDialog.vue'));

const app = createApp(App)

const pinia = createPinia();
pinia.use(piniaPluginPersistedstate)
pinia.use(({ store }) => { store.router = markRaw(router) });
app.use(pinia)
app.use(router)

app.component('BaseCard', BaseCard)
app.component('BaseButton', BaseButton)
app.component('BaseBadge', BaseBadge)
app.component('BaseSpinner', BaseSpinner)
app.component('BaseDialog', BaseDialog)

app.mount('#app')
