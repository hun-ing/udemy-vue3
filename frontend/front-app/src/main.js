import App from './App.vue';
import {createApp} from 'vue'
import {createPinia} from 'pinia'
import BaseModal from "@/components/BaseModal.vue";
import {createRouter, createWebHistory} from "vue-router";
import AllUsers from "@/pages/AllUsers.vue";
import CourseGoals from "@/pages/CourseGoals.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/', component: AllUsers
        },
        {
            path: '/goals', component: CourseGoals
        },
    ]
});

const app = createApp(App)

app.use(createPinia())
app.use(router);

app.component('BaseModal', BaseModal);

router.isReady().then(() => {
    app.mount('#app')
})
