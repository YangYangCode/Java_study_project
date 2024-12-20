import axios from "axios";

// 建立 Axios 實利  // 這會再請求加上 token
const api = axios.create({
    baseURL: "http://localhost:9001",
    headers: {
        "Content-Type": "application/json",
    }
})

const API_BASE_URL = "http://localhost:9001";

/**
 * 登入
 * @param {string} username 用戶名
 * @param {string} password 密碼\
 * @param {string} type 類別
 * @returns {Promise<Object>} 包含登入結果的 API 回應
 */
export const login = async (username, password, type) => {
    const response = await fetch(`${API_BASE_URL}/auth/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        credentials: "include",
        body: JSON.stringify({ username, password, type }),
    });

    if (!response.ok) {
        throw new Error("登入失敗");
    }

    return response.json();
};

/**
 * 登出
 * @returns {Promise<Object>} 包含登出結果的 API 回應
 */
export const logout = async () => {
    const response = await fetch(`${API_BASE_URL}/auth/logout`, {
        method: "GET",
        credentials: "include",
    });

    if (!response.ok) {
        throw new Error("登出失敗");
    }

    return response.json();
};

/**
 * 檢查登入狀態
 * @returns {Promise<Object>} 包含登入狀態的 API 回應
 */
export const checkLoginStatus = async () => {
    const response = await fetch(`${API_BASE_URL}/auth/isLoggedIn`, {
        method: "GET",
        credentials: "include",
    });

    if (!response.ok) {
        throw new Error("無法取得登入狀態");
    }

    return response.json();
};



// ApiClient.interceptors.request.use(
//     (confug) => {

//         const token = localStorage.getItem("token");
//         if (token) {
//             // 在 token 前面加入 Bearer 讓後端判斷
//         }
//     }
// )


// login    // login    // login    // login    // login    
// export const login = async (username, password, type) => {
//     try {                                                                                                           // 必須攜帶憑證
//         const login = await api.post(`/auth/login`, { "username": username, "password": password, "type": type }, { withCredentials: true } )
//         console.log(login.data);
//     } catch (error) {
//         console.log("Error login: ", error);

//     }
// }

// export const logout = async () => {
//     try {
//         const logout = await api.get(`/auth/logout`)
//         console.log(logout.data);
//     } catch (error) {
//         console.log("Error logout: ", error);
//     }
// }



// member    // member    // member    // member    // member
export const membe_signAS = async (memberId, ASId) => {    // 會員參與活動
    try {
        const signAS = await api.post(`/member/sign/${memberId}/${ASId}`);
        console.log(signAS.data);
        return signAS.data;
    } catch (error) {
        console.log("Error signAS: ", error);
    }
}

export const membe_cancelAS = async (memberId, ASId) => {    // 會員取消活動
    try {
        const cancelAS = await api.post(`/member/cancel/${memberId}/${ASId}`);
        console.log(cancelAS.data);
        return cancelAS.data;
    } catch (error) {
        console.log("Error cancelAS: ", error);
    }
}

export const get_all_member = async () => {    // 取得所有會員
    try {
        const memberList = await api.get(`/member`);
        console.log(memberList.data);
        return memberList.data.data;
    } catch (error) {
        console.log("Error getMemberList: ", error);
    }
}

export const get_membe_by_id = async (memberId) => {    // 取得特定會員
    try {
        const member = await api.get(`/member/${memberId}`);
        console.log(member.data);
        return member.data.data;
    } catch (error) {
        console.log("Error getMember: ", error);
    }
}

export const get_AS_list_by_member_id = async (memberId) => {    // 取得特定會員參加的所有活動參
    try {
        const ASList = await api.get(`/member/list/${memberId}`);
        console.log(ASList.data);
        return ASList.data.data;
    } catch (error) {
        console.log("Error getASList: ", error);
    }
}

export const post_create_member = async (memberDTO) => {    // 新增會員
    try {
        const response = await api.post(`/member`, memberDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error createMember: ", error);
    }
}

export const update_member_by_id = async (memberId, memberDTO) => {    // 更新會員
    try {
        const response = await api.put(`/member/${memberId}`, memberDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error updateMember: ", error);
    }
}

export const delete_member_by_id = async (memberId) => {    // 刪除會員
    try {
        const response = await api.delete(`/member/${memberId}`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error deleteMember: ", error);
    }
}





// activitySchedule    // activitySchedule    // activitySchedule    // activitySchedule    // activitySchedule
export const get_activitySchedule_by_id = async (activityScheduleId) => {    // 取得特定活動
    try {
        const activitySchedule = await api.get(`/activityschedule/${activityScheduleId}`);
        console.log(activitySchedule.data);
        return activitySchedule.data.data;
    } catch (error) {
        console.log("Error getActivitySchedule: ", error);
    }
}

export const get_all_activitySchedule = async () => {    // 取得所有活動
    try {
        const activityScheduleList = await api.get(`/activityschedule`);
        console.log(activityScheduleList.data.data);
        return activityScheduleList.data.data;
    } catch (error) {
        console.log("Error getAllActivitySchedule: ", error);
    }
}

export const get_activitySchedule_members = async (activityScheduleId) => {    // 活動已報名會員
    try {
        const activityScheduleList = await api.get(`/activityschedule/members/${activityScheduleId}`);
        console.log(activityScheduleList.data);
        return activityScheduleList.data.data;
    } catch (error) {
        console.log("Error getAllActivitySchedule: ", error);
    }
}

export const post_create_activitySchedule = async (activityScheduleDTO) => {    // 新增活動
    try {
        const response = await api.post(`/activityschedule`, activityScheduleDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error createActivitySchedule: ", error);
    }
}

export const update_activitySchedule_by_id = async (activityScheduleId, activityScheduleDTO) => {    // 修改活動
    try {
        const response = await api.put(`/activityschedule/${activityScheduleId}`, activityScheduleDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error updateActivitySchedule: ", error);
    }
}

export const delete_activitySchedule_by_id = async (activityScheduleId) => {    // 刪除活動
    try {
        const response = await api.delete(`/activityschedule/${activityScheduleId}`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error deleteActivitySchedule: ", error);
    }
}





// activitymanager    // activitymanager    // activitymanager    // activitymanager    // activitymanager    
export const get_activityManager_by_id = async (activityManagerId) => {    // 取得特定管理者
    try {
        const activityManager = await api.get(`/activitymanager/${activityManagerId}`);
        console.log(activityManager.data);
        return activityManager.data.data;
    } catch (error) {
        console.log("Error getActivityManager: ", error);
    }
}

export const get_all_activityManager = async () => {    // 取得所有管理者
    try {
        const activityManagerList = await api.get(`/activitymanager`);
        console.log(activityManagerList.data);
        return activityManagerList.data.data;
    } catch (error) {
        console.log("Error getAllActivityManager: ", error);
    }
}

export const get_activityManager_ASlsit = async (activityManagerId) => {    // 管理員所管理活動
    try {
        const activityScheduleList = await api.get(`/activitymanager/list/${activityManagerId}`);
        console.log(activityScheduleList.data);
        return activityScheduleList.data.data;
    } catch (error) {
        console.log("Error getActivityScheduleList: ", error);
    }
}

export const post_create_activityManager = async (activityManagerDTO) => {    // 新增活動
    try {
        const response = await api.post(`/activityschedule`, activityManagerDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error createActivityManager: ", error);
    }
}

export const update_activityManager_by_id = async (activityManagerId, activityManagerDTO) => {    // 修改活動
    try {
        const response = await api.put(`/activityschedule/${activityManagerId}`, activityManagerDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error updateActivityManager: ", error);
    }
}

export const delete_activityManager_by_id = async (activityManagerId) => {    // 刪除活動
    try {
        const response = await api.delete(`/activityschedule/${activityManagerId}`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error deleteActivityManager: ", error);
    }
}





// classroom    // classroom    // classroom    // classroom    // classroom    
export const get_classRoom_by_id = async (classRoomId) => {    // 取得特定房間
    try {
        const classRoom = await api.get(`/classroom/${classRoomId}`);
        console.log(classRoom.data);
        return classRoom.data.data;
    } catch (error) {
        console.log("Error getClassRoom: ", error);
    }
}

export const get_all_classRoom = async () => {    // 取得所有房間
    try {
        const classRoomList = await api.get(`/classroom`);
        console.log(classRoomList.data);
        return classRoomList.data.data;
    } catch (error) {
        console.log("Error getAllClassRoom: ", error);
    }
}

export const get_classRoom_ASList = async (classRoomId) => {    // 取得在該房間舉辦的活動
    try {
        const activityScheduleList = await api.get(`/classroom/list/${classRoomId}`);
        console.log(activityScheduleList.data);
        return activityScheduleList.data.data;
    } catch (error) {
        console.log("Error getActivityScheduleList: ", error);
    }
}

export const post_create_classRoom = async (classRoomDTO) => {    // 新增活動
    try {
        const response = await api.post(`/classroom`, classRoomDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error createClassRoom: ", error);
    }
}

export const update_classRoom_by_id = async (classRoomId, classRoomDTO) => {    // 修改活動
    try {
        const response = await api.put(`/classroom/${classRoomId}`, classRoomDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error updateClassRoom: ", error);
    }
}

export const delete_classRoom_by_id = async (classRoomId) => {    // 刪除活動
    try {
        const response = await api.delete(`/classroom/${classRoomId}`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error deleteClassRoom: ", error);
    }
}





// classType    // classType    // classType    // classType    // classType  
export const get_classType_by_id = async (classTypeId) => {    // 取得特定課程
    try {
        const classType = await api.get(`/classtype/${classTypeId}`);
        console.log(classType.data);
        return classType.data.data;
    } catch (error) {
        console.log("Error getClassType: ", error);
    }
}

export const get_all_classType = async () => {    // 取得所有課程
    try {
        const classTypeList = await api.get(`/classtype`);
        console.log(classTypeList.data);
        return classTypeList.data.data;
    } catch (error) {
        console.log("Error getAllClassType: ", error);
    }
}

export const get_classType_ASList = async (classTypeId) => {    // 所有舉辦這課程的活動
    try {
        const activityScheduleList = await api.get(`/classtype/list/${classTypeId}`);
        console.log(activityScheduleList.data);
        return activityScheduleList.data.data;
    } catch (error) {
        console.log("Error getActivityScheduleList: ", error);
    }
}

export const post_create_classType = async (classTypeDTO) => {    // 新增課程
    try {
        const response = await api.post(`/classtype`, classTypeDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error createClassType: ", error);
    }
}

export const update_classType_by_id = async (classTypeId, classTypeDTO) => {    // 修改課程
    try {
        const response = await api.put(`/classtype/${classTypeId}`, classTypeDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error updateClassType: ", error);
    }
}

export const delete_classType_by_id = async (classTypeId) => {    // 刪除課程
    try {
        const response = await api.delete(`/classtype/${classTypeId}`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error deleteClassType: ", error);
    }
}





// fitnessInstructor    // fitnessInstructor    // fitnessInstructor    // fitnessInstructor    // fitnessInstructor    
export const get_fitnessInstructor_by_id = async (fitnessInstructorId) => {    // 取得特定教練
    try {
        const fitnessInstructor = await api.get(`/instructor/${fitnessInstructorId}`);
        console.log(fitnessInstructor.data);
        return fitnessInstructor.data.data;
    } catch (error) {
        console.log("Error getFitnessInstructor: ", error);
    }
}

export const get_all_fitnessInstructor = async () => {    // 取得所有教練
    try {
        const fitnessInstructor = await api.get(`/instructor`);
        console.log(fitnessInstructor.data);
        return fitnessInstructor.data.data;
    } catch (error) {
        console.log("Error getAllFitnessInstructor: ", error);
    }
}

export const get_fitnessInstructor_ASList = async (fitnessInstructorId) => {    // 教練參與的活動
    try {
        const activityScheduleList = await api.get(`/instructor/list/${fitnessInstructorId}`);
        console.log(activityScheduleList.data);
        return activityScheduleList.data.data;
    } catch (error) {
        console.log("Error getActivityScheduleList: ", error);
    }
}

export const post_create_fitnessInstructor = async (fitnessInstructorDTO) => {    // 新增教練
    try {
        const response = await api.post(`/instructor`, fitnessInstructorDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error createFitnessInstructor: ", error);
    }
}

export const update_fitnessInstructor_by_id = async (fitnessInstructorId, fitnessInstructorDTO) => {    // 修改教練
    try {
        const response = await api.put(`/instructor/${fitnessInstructorId}`, fitnessInstructorDTO);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error updateFitnessInstructor: ", error);
    }
}

export const delete_fitnessInstructor_by_id = async (fitnessInstructorId) => {    // 刪除教練
    try {
        const response = await api.delete(`/instructor/${fitnessInstructorId}`);
        console.log(response.data);
        return response.data;
    } catch (error) {
        console.log("Error deleteFitnessInstructor: ", error);
    }
}



