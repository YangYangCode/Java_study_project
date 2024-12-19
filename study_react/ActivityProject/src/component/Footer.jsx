import React from "react";

function Footer() {
    return (
        <footer className="fixed bottom-0 left-0 w-full bg-gray-800 text-white text-center py-4 z-50">
            <p className="text-sm">
                &copy; {new Date().getFullYear()} 活動刊登及報名. All rights reserved.
            </p>
            <div className="flex justify-center mt-2 gap-4">
                <a
                    href="/about"
                    className="text-white text-sm hover:underline"
                >
                    關於我們
                </a>
                <a
                    href="/contact"
                    className="text-white text-sm hover:underline"
                >
                    聯絡我們
                </a>
                <a
                    href="/privacy"
                    className="text-white text-sm hover:underline"
                >
                    隱私政策
                </a>
            </div>
        </footer>
    );
}

export default Footer;
