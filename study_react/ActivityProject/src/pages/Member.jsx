import React, { useEffect, useState } from "react";
import BookingForm from "../component/BookingForm";
import { get_AS_list_by_member_id, get_membe_by_id } from "../service/Service_9001_AS";


function Member() {

    const [member,setMember] = useState('');  // getMember
    const [ASListByMember,setASList] = useState('');  // getASListByMember

// 更新member
// useEffect(()=>{
//     const memberData = get_membe_by_id(2);
//     setMember(memberData);
//     console.log(member);
// },[]);

useEffect(()=>{
    const ASList = get_AS_list_by_member_id(1);
    console.log(ASList);
    setASList(ASList);
},[]);



    return (

        <div>
            <div >
                <h1 className="bg-blue-300">會員</h1>
            </div>
            <h1>修改資訊</h1>
            <h1>時刻表</h1>
            <BookingForm/>

        </div>
    )
}

export default Member;