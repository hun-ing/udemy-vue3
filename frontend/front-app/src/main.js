import App from './App.vue';
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { createRouter, createWebHistory } from 'vue-router'
import TeamsList from '@/components/teams/TeamsList.vue'
import UsersList from '@/components/users/UsersList.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/teams', component: TeamsList},
    { path: '/users', component: UsersList}
  ]
})

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.mount('#app')
