import { request } from "../utils/request";

// 根据不同分类从后端获取数据
export function Report() {
    return request({
        method: 'get',
        url: '/sales/summary',
        headers: {
            'Authorization': window.localStorage.getItem('token'), // 使用getItem来安全地获取token
        },
    })
}