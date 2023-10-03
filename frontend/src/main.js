import { createApp } from 'vue'
import App from './App.vue'
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';
import { createRouter, createWebHistory } from 'vue-router' // Importeer de router

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Home',
            component: () => import('./components/HomeScreen.vue'),
        },
        {
            path :'/speeldagenToevoegen',
            name: "SpeeldagenToevoegen",
            component: () => import('./components/SpeeldagenToevoegen.vue')
        },
        {
            path:'/uitgavenToevoegen',
            name:"UitgavenToevoegen",
            component : () => import('./components/Uitgaven')
        }
        // Bijvoorbeeld: { path: '/', component: Home }
    ],
})

createApp(App).use(router).use(Vuetify).mount('#app')
