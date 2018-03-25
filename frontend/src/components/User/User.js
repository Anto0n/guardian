import React from "react";
import PropTypes from "prop-types";

const User = (props) => {
    return (
        <div>
            <span>{props.firstName}</span>
        </div>
    );
};

User.propTypes = {
    firstName: PropTypes.string.isRequired
};

export default User;