package org.grails.cli.profile

import spock.lang.Specification

class ProfileRepositorySpec extends Specification {
    GitProfileRepository profileRepository
    
    def setup() {
        profileRepository = new GitProfileRepository(initialized:true, profilesDirectory: new File('src/test/resources/profiles-repository'))
    }
    
    def "should return profile"() {
        expect:
        profileRepository.getProfile('web') != null
    }
    
    def "should return null if profile doesn't exist"() {
        expect:
        profileRepository.getProfile('unknown') == null
    }
    
}