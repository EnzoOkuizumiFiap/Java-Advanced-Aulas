import http from 'k6/http';
import { check } from 'k6';

export const options = {
    vus: 50,          // 20 usuários simultâneos
    iterations: 50,   // total de 20 requisições (1 por usuário)
    duration: '2s'
};

export default function () {
    const res = http.post('http://localhost:8080/tickets/purchase/');

    check(res, {
        'status is 200': (r) => r.status === 200,
    });
}