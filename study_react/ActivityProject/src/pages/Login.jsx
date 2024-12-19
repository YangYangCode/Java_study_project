import React, { useEffect, useState } from "react";
import {  } from "../service/Service_AS";


function LoginPage({ onLogin }) {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [type, setType] = useState("member");

    const handleSubmit = (e) => {
        e.preventDefault();
        onLogin(username, password); // 呼叫 onLogin 進行登入驗證
    };

    return (
        <div className="w-full max-w-md mx-auto mt-24 p-6 rounded-lg bg-gray-100 shadow-md">
            <h2 className="text-2xl font-bold text-center text-gray-800 mb-6">登入</h2>
            <form onSubmit={handleSubmit}>
                {/* 下拉選單 */}
                <label htmlFor="user_type" className="block text-sm font-bold text-gray-700 mb-2">
                選擇用戶類型:
            </label>
            <select
                id="user_type"
                name="user_type"
                value={type}
                onChange={(e) => setType(e.target.value)}
                className="w-full p-3 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500 mb-2 bg-gray-100"
            >
                <option value="member">會員</option>
                <option value="fitnessInstructors">教練</option>
            </select>

                {/* 帳號輸入欄 */}
                <div className="mb-4">
                    <label htmlFor="username" className="block text-sm font-bold text-gray-700 mb-2">
                        帳號：
                    </label>
                    <input
                        type="text"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                        className="w-full p-3 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
                    />
                </div>
                {/* 密碼輸入欄 */}
                <div className="mb-6">
                    <label htmlFor="password" className="block text-sm font-bold text-gray-700 mb-2">
                        密碼：
                    </label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                        className="w-full p-3 border border-gray-300 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
                    />
                </div>
                {/* 登入按鈕 */}
                <button
                    type="submit"
                    className="w-full py-3 text-white bg-blue-600 rounded hover:bg-blue-700 active:bg-blue-800 text-lg font-semibold"
                >
                    登入
                </button>
            </form>
        </div>
    );
}

export default LoginPage;