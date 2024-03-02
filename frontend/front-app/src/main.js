import App from './App.vue'
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import router from '@/router.js'
import BaseCard from '@/components/ui/BaseCard.vue'
import BaseButton from '@/components/ui/BaseButton.vue'
import BaseBadge from '@/components/ui/BaseBadge.vue'
import BaseSpinner from '@/components/ui/BaseSpinner.vue';
import BaseDialog from '@/components/ui/BaseDialog.vue';

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.component('BaseCard', BaseCard)
app.component('BaseButton', BaseButton)
app.component('BaseBadge', BaseBadge)
app.component('BaseSpinner', BaseSpinner)
app.component('BaseDialog', BaseDialog)

app.mount('#app')
